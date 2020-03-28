package com.company;

/*

1901 TableAdapter
Change the TableAdapter class so that it adapts ATable to BTable.
The getHeaderText method should return such a string "[username]: tablename".
Example, "[Amigo]: DashboardTable".
Requirements:
1. The Solution class must contain the ATable public static interface.
2. The Solution class must contain the BTable public static interface.
3. The Solution class must contain the public static TableAdapter class.
4. The TableAdapter class must implement the BTable interface.
5. The TableAdapter class must contain a private field of aTable of type ATable.
6. The TableAdapter class must contain a constructor with the ATable parameter.
7. The TableAdapter class must override the getHeaderText method as specified.

 */

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


//Принято
public class Solution {
    public static void main(String[] args) {
        ATable aTable = new ATable() {
            @Override
            public String getCurrentUserName() {
                return "Amigo";
            }
            @Override
            public String getTableName() {
                return "DashboardTable";
            }
        };
        BTable table = new TableAdapter(aTable);
        System.out.println(table.getHeaderText());
    }
    public static class TableAdapter implements BTable {
        private ATable aTable;
        public TableAdapter(ATable aTable) {
            this.aTable = aTable;
        }
        @Override
        public String getHeaderText() {
            return String.format("[%s] : %s", aTable.getCurrentUserName(), aTable.getTableName());
        }
    }
    public interface ATable {
        String getCurrentUserName();
        String getTableName();
    }
    public interface BTable {
        String getHeaderText();
    }
}


