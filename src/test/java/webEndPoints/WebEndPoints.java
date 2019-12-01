package webEndPoints;

public enum WebEndPoints {	
    INCLUIR_PESSOA("%s/pessoas/"),
	CONSULTAR_PESSOA("%s/pessoas/{ddd}/{telefone}");

    private final String url;

    WebEndPoints(String url) {
        this.url = url;
    }

    public String getUrl() throws Exception {
        return String.format(url, new ReadProperties().read().get("url_server"));
    }
    
}