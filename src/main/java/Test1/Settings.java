package Test1;

public class Settings {
    public String adressWebSite = "https://www.rencredit.ru/";
    public String pathDownloadFile = System.getProperty("user.dir")+"\\obshchie-usloviya-po-vkladam-i-schetam_02.04.2018";
    public String openFile = pathDownloadFile + "\\obshchie-usloviya-po-vkladam-i-schetam_02.04.2018.pdf";
    public boolean writeBd = false;

    public String getAdressWebSite() {
        return adressWebSite;
    }

    public void setAdressWebSite(String adressWebSite) {
        this.adressWebSite = adressWebSite;
    }

    public String getPathDownloadFile() {
        return pathDownloadFile;
    }

    public void setPathDownloadFile(String pathDownloadFile) {
        this.pathDownloadFile = pathDownloadFile;
    }

    public boolean isWriteBd() {
        return writeBd;
    }

    public void setWriteBd(boolean writeBd) {
        this.writeBd = writeBd;
    }
}
