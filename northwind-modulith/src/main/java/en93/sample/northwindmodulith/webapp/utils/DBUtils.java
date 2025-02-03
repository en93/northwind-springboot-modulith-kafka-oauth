package en93.sample.northwindmodulith.webapp.utils;

import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Record;
import org.springframework.stereotype.Component;

@Component
public class DBUtils {

    private final DSLContext dslContext;

    public DBUtils(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    public <T> T filterType(Record jooqRecord, Class<T> clazz, String type) {
        var filteredRecord = jooqRecord.fieldStream()
                .filter(x -> x.getName().startsWith(String.format("\"public\".\"%s\"", type)))
                .toArray(Field[]::new);
        return dslContext.newRecord(filteredRecord).into(clazz);
    }
}
