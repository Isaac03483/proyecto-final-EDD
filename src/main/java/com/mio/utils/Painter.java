package com.mio.utils;

import com.mio.models.abbTree.Node;
import com.mio.models.abbTree.Tree;
import com.mio.models.table.Property;
import com.mio.models.table.Table;

public class Painter {

        public static String createImage(Tree tree){
            StringBuilder fileContent = new StringBuilder();

            fileContent.append("digraph {\n");

            getContent(tree.root, fileContent);

            fileContent.append("}");

            return fileContent.toString();

        }

        public static void getContent(Node<Table> tableNode, StringBuilder fileContent){
            if(tableNode != null){
                Table currentTable = tableNode.value;
                fileContent.append(currentTable.tableName)
                        .append(" [label= \"").append(currentTable.tableName)
                        .append("\", shape= \"square\"]\n");

                com.mio.models.list.Node<Property> propertyNode = currentTable.properties.firstNode;
                while(propertyNode != null){
                    Property property = propertyNode.value;
                    fileContent.append(currentTable.tableName).append("_").append(property.propertyName)
                            .append("[label= \"").append(property.propertyName).append("\"]\n");

                    fileContent.append(currentTable.tableName)
                            .append("->")
                            .append(currentTable.tableName).append("_").append(property.propertyName).append("\n");

                    propertyNode = propertyNode.next;
                }

                if(currentTable.parentName != null){
                    fileContent.append(currentTable.tableName).append("->").append(currentTable.parentName).append("\n");
                }

                getContent(tableNode.leftChildren, fileContent);
                getContent(tableNode.rightChildren, fileContent);
            }
        }
}
