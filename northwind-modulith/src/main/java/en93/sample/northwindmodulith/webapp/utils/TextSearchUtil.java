package en93.sample.northwindmodulith.webapp.utils;

import org.springframework.stereotype.Component;

@Component
public class TextSearchUtil {

    //Will match with any terms in query using OR logic
    public String formatQueryForSearch(String searchQuery){
        return searchQuery != null ? searchQuery.trim().replace(" ", " | ") : null;
    }

}
