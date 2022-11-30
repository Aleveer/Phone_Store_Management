package entity;

public class Configuation {
	 private String Screen, OS, Chip, Ram, Memory, Battery, FrontCamera, RearCamera, ID_Product;
	    public Configuation() {
	        super();
	    }
	    public Configuation(String ID_Product, String Screen, String OS, String Chip, String Ram, String Memory, String Battery, String FrontCamera, String RearCamera) {
	        super();
	        this.ID_Product = ID_Product;
	        this.Screen = Screen;
	        this.OS = OS;
	        this.Chip = Chip;
	        this.Ram = Ram;
	        this.Memory = Memory;
	        this.Battery = Battery;
	        this.FrontCamera = FrontCamera;
	        this.RearCamera = RearCamera;
	    }
	    public String getID_Product() {
	        return ID_Product;
	    }
	    public void setID_Product(String  ID_Product) {
	        this.ID_Product = ID_Product;
	    }
	    public String getScreen() {
	        return Screen;
	    }
	    public void setScreen(String Screen) {
	        this.Screen = Screen;
	    }
	    public String getOS() {
	        return OS;
	    }
	    public void setOS(String OS) {
	        this.OS = OS;
	    }
	    public String getChip() {
	        return Chip;
	    }
	    public void setChip(String Chip) {
	        this.Chip = Chip;
	    }
	    public String getRam() {
	        return Ram;
	    }
	    public void setRam(String Ram) {
	        this.Ram = Ram;
	    }
	    public String getMemory() {
	        return Memory;
	    }
	    public void setMemory(String Memory) {
	        this.Memory = Memory;
	    }
	    public String getBattery() {
	        return Battery;
	    }
	    public void setBattery(String Battery) {
	        this.Battery = Battery;
	    }
	    public String getFrontCamera() {
	        return FrontCamera;
	    }
	    public void setFrontCamera(String FrontCamera) {
	        this.FrontCamera = FrontCamera;
	    }
	    public String getRearCamera() {
	        return RearCamera;
	    }
	    public void setRearCamera(String RearCamera) {
	        this.RearCamera = RearCamera;
	    }
}
