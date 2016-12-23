package br.com.universal.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

public class SkinBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5634501729488429679L;
	private static List<SelectItem> SKINS;
	
	static {
		SKINS = new ArrayList<SelectItem>(11);
		SKINS.add(new SelectItem("laguna", "Laguna"));
		SKINS.add(new SelectItem("blueSky", "BlueSky"));
		SKINS.add(new SelectItem("classic", "Classic"));
		SKINS.add(new SelectItem("ruby", "Ruby"));
		SKINS.add(new SelectItem("wine", "Wine"));
		SKINS.add(new SelectItem("deepMarine", "DeepMarine"));
		SKINS.add(new SelectItem("emeraldTown", "EmeraldTown"));
		SKINS.add(new SelectItem("japanCherry", "Sakura"));
		SKINS.add(new SelectItem("plain", "Plain"));
		SKINS.add(new SelectItem("DEFAULT", "Default"));
		SKINS.add(new SelectItem("NULL", "Null"));
	}
	
	private String skin = "classic";

	public String getSkin() {
		return skin;
	}

	public void setSkin(String skin) {
		this.skin = skin;
	}
	
	public List<SelectItem> getSkinsList() {
		return SKINS;
	}
}
