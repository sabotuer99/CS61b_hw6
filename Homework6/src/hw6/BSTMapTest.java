package hw6;

import static org.junit.Assert.*;

import java.util.ArrayList;

import hw6.BSTMap;

import org.junit.Test;

public class BSTMapTest {

	 @Test
	    public void Get_KeyFound_ReturnsValue() {
	    	//Arrange
	        BSTMap<String, String> um = new BSTMap<String, String>();
	        um.put("Gracias", "Dios Basado");
	        
	        //Act
	        String result = um.get("Gracias");
	        
	        //Assert
	        assertEquals("Dios Basado", result);
	    }
	    
	    @Test
	    public void Get_JapaneseKeyFound_ReturnsJapaneseValue() {
	    	//Arrange
	        BSTMap<String, String> um = new BSTMap<String, String>();
	        um.put("Gracias", "Dios Basado");
	        um.put("Спасибо", "Пожалуйста");
	        um.put("ありがとう", "どう致しまして");
	        um.put("Þakka þér fyrir", "Það var ekkert");
	        um.put("Thank You", "You're Welcome");
	        
	        //Act
	        String result = um.get("ありがとう");
	        
	        //Assert
	        assertEquals("どう致しまして", result);
	    }

	    @Test
	    public void RemoveK_KeyFound_ReturnsValueRemovesNode() {
	    	//Arrange
	        BSTMap<String, String> um = new BSTMap<String, String>();
	        um.put("Gracias", "Dios Basado");
	        
	        //Act
	        String removed = um.remove("Gracias");
	        
	        //Assert
	        assertEquals("Dios Basado", removed);
	        assertFalse(um.containsKey("Gracias"));
	    }
	    
	    @Test
	    public void RemoveKV_KeyFoundValDiff_DoNothing() {
	    	//Arrange
	        BSTMap<String, String> um = new BSTMap<String, String>();
	        um.put("Gracias", "Dios Basado");
	        
	        //Act
	        String removed = um.remove("Gracias", "Blarg");       
	        
	        //Assert
	        assertEquals(null, removed);
	        assertTrue(um.containsKey("Gracias"));
	    }
	    
	    @Test
	    public void RemoveKV_KeyValFoundVal_RemoveNodeReturnVal() {
	    	//Arrange
	        BSTMap<String, String> um = new BSTMap<String, String>();
	        um.put("Gracias", "Dios Basado");
	        
	        //Act
	        String removed = um.remove("Gracias", "Dios Basado");       
	        
	        //Assert
	        assertEquals("Dios Basado", removed);
	        assertFalse(um.containsKey("Gracias"));
	    }
	    
	    @Test
	    public void Size_OneKeyValue_ReturnsOne() {
	    	//Arrange
	        BSTMap<String, String> um = new BSTMap<String, String>();
	        um.put("Gracias", "Dios Basado");
	        
	        //Act
	        int result = um.size();       
	        
	        //Assert
	        assertEquals(1, result);
	    }
	    
	    @Test
	    public void Size_FiveKeyValues_ReturnsFive() {
	    	//Arrange
	        BSTMap<String, String> um = new BSTMap<String, String>();
	        um.put("Gracias", "Dios Basado");
	        um.put("Спасибо", "Пожалуйста");
	        um.put("ありがとう", "どう致しまして");
	        um.put("Þakka þér fyrir", "Það var ekkert");
	        um.put("Thank You", "You're Welcome");
	        
	        //Act
	        int result = um.size();       
	        
	        //Assert
	        assertEquals(5, result);
	    }
	    
	    @Test
	    public void Size_EmptyList_ReturnsZero() {
	    	//Arrange
	        BSTMap<String, String> um = new BSTMap<String, String>();
	        
	        //Act
	        int result = um.size();       
	        
	        //Assert
	        assertEquals(0, result);
	    }
	    
	    @Test
	    public void Clear_FiveKeyValues_ClearsOutList() {
	    	//Arrange
	        BSTMap<String, String> um = new BSTMap<String, String>();
	        um.put("Gracias", "Dios Basado");
	        um.put("Спасибо", "Пожалуйста");
	        um.put("ありがとう", "どう致しまして");
	        um.put("Þakka þér fyrir", "Það var ekkert");
	        um.put("Thank You", "You're Welcome");
	        
	        //Act
	        um.clear();       
	        
	        //Assert
	        assertEquals(0, um.size());
	    }
	    
	    @Test
	    public void InOrder_FiveKeyValues_ClearsOutList() {
	    	//Arrange
	        BSTMap<String, String> um = new BSTMap<String, String>();
	        um.put("Coconut", "Brown");
	        um.put("Date", "Brown");
	        um.put("Apple", "Red");
	        um.put("Banana", "Yellow");
	        um.put("Elderberry", "Purple");
	        //um.printInOrder();
	        
	        //Act
	        ArrayList<String> keys = um.getKeysInOrder();       
	        
	        //Assert
	        assertEquals("Apple", keys.get(0));
	        assertEquals("Banana", keys.get(1));
	        assertEquals("Coconut", keys.get(2));
	        assertEquals("Date", keys.get(3));
	        assertEquals("Elderberry", keys.get(4));
	    }
	    
	    @Test
	    public void Remove_RootNodeComplexTree_DeletesCorrectly() {
	    	//Arrange
	        BSTMap<String, String> um = new BSTMap<String, String>();
	        um.put("Coconut", "Brown");
	        um.put("Date", "Brown");
	        um.put("Cz", "Black");
	        um.put("Apple", "Red");
	        um.put("Ab", "Black");
	        um.put("Banana", "Yellow");
	        um.put("Elderberry", "Purple");
	        //um.printInOrder();
	        
	        //Act
	        um.remove("Coconut");      
	        
	        //Assert
	        ArrayList<String> keys = um.getKeysInOrder(); 
	        assertEquals("Ab", keys.get(0));
	        assertEquals("Apple", keys.get(1));
	        assertEquals("Banana", keys.get(2));
	        assertEquals("Cz", keys.get(3));
	        assertEquals("Date", keys.get(4));
	        assertEquals("Elderberry", keys.get(5));
	    }

}
