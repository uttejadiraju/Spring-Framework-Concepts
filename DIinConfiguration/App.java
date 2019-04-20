package DIinConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class App {
	@Autowired
	private DataSourceConfig dataSourceConfig;

	@Bean
	Client clientBean() {
		return new Client(dataSourceConfig.dataSourceBean());
	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(App.class,
				DataSourceConfig.class);
		context.getBean(Client.class).showData();
		context.close();
	}
}

@Configuration
class DataSourceConfig {

	@Bean
	DataSourceBean dataSourceBean() {
		return new DataSourceBean();
	}
}

class Client {
	private DataSourceBean dataSourceBean;

	Client(DataSourceBean dataSourceBean) {
		this.dataSourceBean = dataSourceBean;
	}

	public void showData() {
		System.out.println(dataSourceBean.getData());
	}
}

class DataSourceBean {

    public String getData() {
        return "some data";
    }
}