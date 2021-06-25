package lt.lb.fakedatasource.structure;

/**
 *
 * @author laim0nas100
 */
public class FakeTable {
    public static enum TableType{
        TABLE("TABLE"),
        VIEW("VIEW"),
        SYSTEM("SYSTEM TABLE"),
        GLOBAL_TEMP("GLOBAL TEMPORARY"),
        LOCAL_TEMP("LOCAL TEMPORARY"),
        ALIAS("ALIAS"),
        SYNONYM("SYNONYM");
        
        public final String name;
        private TableType(String name) {
            this.name = name;
        }
        
    }
    
    public String tableCatalog = "FakeCatalog";
    public String tableSchema = "FakeSchema";
    public String tableName = "FakeName";
    public TableType tableType = TableType.TABLE;
    
    
}
