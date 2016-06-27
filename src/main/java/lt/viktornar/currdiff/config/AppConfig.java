package lt.viktornar.currdiff.config;

import lt.viktornar.currdiff.service.SettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

import java.text.SimpleDateFormat;

@Configuration
@ComponentScan("lt.viktornar")
@PropertySources({
        @PropertySource("classpath:application.properties")
})
public class AppConfig {
    @Autowired
    private Environment env;

    @Bean
    public SettingsService getSettingsService() {
        SettingsService settingsService = new SettingsService();
        settingsService.setServiceUrl(env.getProperty("service.url"));
        return settingsService;
    }

    @Bean
    @Qualifier(value = "customSimpleDateFormat")
    public SimpleDateFormat getSimpleDateFormat() {
        SimpleDateFormat format = new SimpleDateFormat(env.getProperty("date.format"));
        return  format;
    }
}
