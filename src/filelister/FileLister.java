package filelister;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.util.Date;
import java.text.DateFormat;



/**
 *
 * @author raymond.l.mcclendon (the man)
 */
public class FileLister {
    String dir;
    /**
     * @param args the command line arguments
     */
    
   
    public static void main(String[] args) {
        String dir = "d:\\";
        if (args.length > 0) {
          dir = args[0].toString();      
        }
        //else {
        //   System.out.println("Error: no directory provided. Try 'java -jar FileLister.jar directoy_name' where directory_name is the name of the directory you wish to list all files for");
        //   System.exit(0); 
        // }
        
        
        // TODO code application logic here
        //ListFilesUtil listFilesUtil = new ListFilesUtil();
        FileLister fileListerlist = new FileLister(); 
        fileListerlist.listFilesAndFilesSubDirectories(dir);
    }
    
    
        


//}    
//}

//public class ListFilesUtil { 
  
     
  /** 
   * List all the files and folders from a directory 
   * @param directoryName to be listed 
   */
    
public void listFilesAndFolders(String directoryName){ 
          
    File directory = new File(directoryName); 

    //get all the files from a directory        
    File[] fList = directory.listFiles(); 

    for (File file : fList){          
    System.out.println(file.getName());     
    } 
}

/**      
* List all the files under a directory      
* @param directoryName to be listed      
*/
    
public void listFiles(String directoryName){ 
        
    File directory = new File(directoryName); 

    //get all the files from a directory      
    File[] fList = directory.listFiles();         
    for (File file : fList){ 
       if (file.isFile()){               
          System.out.println(file.getName());       
       }      
    } 
}    
   
/**      
 * List all the folder under a directory      
 * @param directoryName to be listed      
*/
    
public void listFolders(String directoryName){ 
        
File directory = new File(directoryName); 
        
//get all the files from a directory         
File[] fList = directory.listFiles(); 
        
for (File file : fList){            
    if (file.isDirectory()){                
      System.out.println(file.getName()); 
    } 
}     
    
} 

/**     
* List all files from a directory and its subdirectories    
* @param directoryName to be listed      
*/
    
public void listFilesAndFilesSubDirectories(String directoryName){ 
        
File directory = new File(directoryName); 
        
//get all the files from a directory 
        
File[] fList = directory.listFiles(); 
String f_path;
String v_dirname = directory.getName();
String v_path = directory.getPath();
long v_file_size, v_millisec;
String v_file_date = "";
String v_formatted_date = "";

Date dt = new Date();

  try {
    for (File file : fList){          
        if (file.isFile()){
          v_millisec = file.lastModified();
          v_file_size = file.length();
          
          if (v_millisec > 0) {
             dt.setTime(v_millisec);
             //v_file_date = dt.toString();
             v_file_date = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT).format(dt);
          }
          f_path = file.getAbsolutePath();
          //C:\AIP\HBSS\MA\MA_Inst.log.1.log
          System.out.println(v_file_date + "|" +
                             v_file_size + "|" +
                             file.getPath());            
        } 
        else if (file.isDirectory()){ 
            listFilesAndFilesSubDirectories(file.getAbsolutePath());         
        }  
    } 
  }
  catch (Exception e) {
      //System.out.println("Exception:java.lang.NullPointerException ");
      e.printStackTrace();

  }
    
} 


}


