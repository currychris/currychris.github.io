package io.github.currychris.afkscroll;

import java.util.*;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.*;
import org.bukkit.event.player.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public final class AfkScroll extends JavaPlugin implements Listener {
	
	private static AfkScroll instance;
	
	FileConfiguration config = getConfig();

	ItemStack scroll;
	
	public AfkScroll() {
		instance = this;
	}
	
	private static AfkScroll getInstance() {
		return instance;
	}
	
	@Override
	public void onEnable() {
		
		this.saveDefaultConfig();

		scroll = new ItemStack(Material.PAPER, 1);
				
		ItemMeta meta = scroll.getItemMeta();
		meta.setDisplayName("AfkScroll");
				
		List<String> lores = new ArrayList<String>();
		lores.add(config.getString("onAfk"));
		lores.add(config.getString("onReturn"));
		meta.setLore(lores);
				
		meta.getPersistentDataContainer().set(new NamespacedKey(getInstance(), "afk"), PersistentDataType.INTEGER, 1);
		scroll.setItemMeta(meta);
		
		getServer().getPluginManager().registerEvents(new Listener() {
			
			@EventHandler
			public void playerHeldItem(PlayerItemHeldEvent event) {
				Player player = event.getPlayer();
				ItemStack newItem = player.getInventory().getItem(event.getNewSlot());
				ItemStack prevItem = player.getInventory().getItem(event.getPreviousSlot());

				ItemMeta newMeta, prevMeta;

				PotionEffect effect = new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 1, true, true);
				
				if(newItem != null && (newMeta = newItem.getItemMeta()).getPersistentDataContainer()
					.has(new NamespacedKey(getInstance(), "afk"), PersistentDataType.INTEGER)) {
					
					List<String> lores = newMeta.getLore();
					
					player.chat(ChatColor.RED + lores.get(0));
					player.setAllowFlight(true);
					player.setFlying(true);
					player.setFlySpeed(0.0f);
					player.setWalkSpeed(0.0f);
					player.setInvulnerable(true);
					player.addPotionEffect(effect);
					
				} else if(prevItem != null && (prevMeta = prevItem.getItemMeta()).getPersistentDataContainer()
					.has(new NamespacedKey(getInstance(), "afk"), PersistentDataType.INTEGER)) {
					
					List<String> lores = prevMeta.getLore();

					player.chat(ChatColor.GREEN + lores.get(1));
					player.setFlying(false);
					player.setFlySpeed(0.1f);
					player.setAllowFlight(false);
					player.setWalkSpeed(0.2f);
					player.setInvulnerable(false);
					player.removePotionEffect(effect.getType());
				}
			}
			
		}, this);
	}
	
	@Override
	public void onDisable() {
		// TODO Insert logic when Plugin is disabled
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("afkscroll")) {
			
			if(args.length == 0){
				if (!(sender instanceof Player)) {
					sender.sendMessage("This command can only be run by a player.");
					
				} else {
					Player player = (Player) sender;
					
					player.getInventory().addItem(new ItemStack(scroll));
				}
			} else if(args.length == 2){
				if(args[0] == "onAfk"){
					config.set("onAfk", args[1]);
				} else if(args[0] == "onReturn"){
					config.set("onReturn", args[1]);
				}else{
					return false;
				}
				
				ItemMeta meta = scroll.getItemMeta();
				List<String> lores = meta.getLore();
				lores.set(0, args[1]);
				meta.setLore(lores);
				scroll.setItemMeta(meta);
			} else {
				return false;
			}
			
			return true;
		}
		
		return false;
	}
}
