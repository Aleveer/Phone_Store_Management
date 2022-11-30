package entity;

public class NhaCungCap {
	   private String maNCC;
	    private String tenNCC;
	    private String diaChi;
	    private String SDT;
	    private String Fax;

	    public NhaCungCap(){
	        super();
	    }
	    public NhaCungCap(String maNCC, String tenNCC, String diaChi, String SDT, String Fax)
	    {
	        this.maNCC=maNCC;
	        this.tenNCC=tenNCC;
	        this.diaChi=diaChi;
	        this.SDT=SDT;
	        this.Fax=Fax;
	    }

	    public String getMaNCC() {
	        return maNCC;
	    }
	    public void setMaNCC(String maNCC) {
	        this.maNCC = maNCC;
	    }

	    public String getTenNCC() {
	        return tenNCC;
	    }
	    public void setTenNCC(String tenNCC) {
	        this.tenNCC = tenNCC;
	    }

	    public String getDiaChi() {
	        return diaChi;
	    }
	    public void setDiaChi(String diaChi) {
	        this.diaChi = diaChi;
	    }

	    public String getSDT() {
	        return SDT;
	    }
	    public void setSDT(String SDT) {
	        this.SDT = SDT;
	    }

	    public String getFax() {
	        return Fax;
	    }
	    public void setFax(String Fax) {
	        this.Fax = Fax;
	    }
}
