package rafaelribeiroestrela.com.github.utilidades.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.stereotype.Component;

@Component
public class VersaoSistema {
	
	@Autowired
	private BuildProperties buildProperties;

    public String getVersion() {
        return buildProperties.getVersion();
    }
    
    public String getGroupId() {
    	return buildProperties.getGroup();
    }
    
    public String getArtifactId() {
    	return buildProperties.getArtifact();
    }
    
    public String getNome() {
    	return buildProperties.getName();
    }

}
