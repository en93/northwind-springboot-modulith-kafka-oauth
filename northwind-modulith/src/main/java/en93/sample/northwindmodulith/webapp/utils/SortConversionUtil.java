package en93.sample.northwindmodulith.webapp.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SortConversionUtil {

    private static final Logger logger = LoggerFactory.getLogger(SortConversionUtil.class);

    public <T> String getEntitySortField(T sortField, Map<T, String> conversionMap){
        try {
            return conversionMap.get(sortField);
        } catch (NullPointerException | IllegalArgumentException e) {
            logger.debug("Missed get from conversionMap for: {}", sortField);
        }
        return null;
    }
}
