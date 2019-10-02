/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import spmprojectapp.FXMLDocumentController;

/**
 *
 * @author RASINDU
 */
public class CheckComplexity {
    
    public int arithmatic(String line){
        int complexity = 0;
        String character = "a";
        line+=character;
        int j = line.length() + 1;
        for (int i = 0; i < line.length() - 1; i++) {
          if(i == j)
              continue;
          
             char c = line.charAt(i);
               char cn = line.charAt(i + 1);
             
             if((c == '+' && cn == '+')){
                 complexity+=1;
                j = i + 1; 
             }else if((c == '-' && cn == '-')){
                 complexity+=1;
                 j = i + 1;
             }
             else if((c == '*' || c == '/' || c == '%' || c == '+') && cn != '='){
                 complexity+=1;
              }else if((c == '-' && cn != '>' && cn != '=')){
                 complexity+=1;
             }
        
        }    
     
        return complexity;
    }
    
    public int relational(String line){
        int complexity = 0;
        String character = "a";
        line+=character;
        int j = line.length() + 1;
        for (int i = 0; i < line.length() - 1; i++) {
          if(i == j)
              continue;
          
             char c = line.charAt(i);
               char cn = line.charAt(i + 1);
             
             if((c == '=' && cn == '=')){
                 complexity+=1;
                j = i + 1; 
             }else if((c == '!' && cn == '=')){
                 complexity+=1;
                 j = i + 1;
             }else if((c == '>' && cn == '=')){
                 if(line.charAt(i - 1) != '>'){
                 complexity+=1;
                 j = i + 1;
                 }
             }else if((c == '<' && cn == '=')){
                 if(line.charAt(i - 1) != '<'){
                 complexity+=1;
                 j = i + 1;
                 }
             }
             else if(c == '>' && cn!= '>'){
                 if(line.charAt(i - 1) != '>' && line.charAt(i - 1) != '-')
                 complexity+=1;
             }
             else if(c == '<' && cn!= '<' ){
                 if(line.charAt(i - 1) != '<')
                 complexity+=1;
                
             }
        
        }    
     
        return complexity;
    }
    
    public int logical(String line){
        int complexity = 0;
        String character = "a";
        line+=character;
        int j = line.length() + 1;
        for (int i = 0; i < line.length() - 1; i++) {
          if(i == j)
              continue;
          
             char c = line.charAt(i);
               char cn = line.charAt(i + 1);
             
             if((c == '&' && cn == '&')){
                 complexity+=1;
                j = i + 1; 
             }else if((c == '|' && cn == '|')){
                 complexity+=1;
                 j = i + 1;
             }else if(c == '!' && cn != '=')
                 complexity+=1;
        
        }    
     
        return complexity;
    }
    
     public int bitwise(String line){
         
       int complexity = 0;
        String character = "abc";
        line+=character;
        int k = line.length() + 1;
        int j = line.length() + 1;
        int l = line.length() + 1;
        for (int i = 0; i < line.length() - 3; i++) {
          if(i == j || i == k || i == l)
              continue;
          
             char c = line.charAt(i);
               char cn = line.charAt(i + 1);
               char cnn = line.charAt(i + 2);
               char cnnn = line.charAt(i + 3);
               
             //System.out.println(str);
             if(c == '<' && cn == '<' && cnn == '<'){
                 complexity+=1;
                 j = i + 1;
                 k = i + 2;
             }else if(c == '>' && cn == '>' && cnn == '>' && cnnn != '='){
                 complexity+=1;
                 j = i + 1;
                 k = i + 2;
             }    
             else if((c == '<' && cn == '<') && cnn != '='){
                 complexity+=1;
                j = i + 1; 
             }else if((c == '>' && cn == '>') && (cnn != '=' && cnn != '>')){
                 complexity+=1;
                 j = i + 1;
             }else if((c == '^' || c == '~') && cn != '=')
                 complexity+=1;
             else if((c == '|' && cn != '|') && cn!= '=' ){
                 if(i == 0){
                     complexity+=1;
                 }else 
                 if(line.charAt(i - 1) != '|')
                 complexity+=1;
             }
        
        }    
     
        return complexity;
    }
     
      public int miscellanous(String line){
        int complexity = 0;
        String character = "a";
        line+=character;
        int j = line.length() + 1;
        for (int i = 0; i < line.length() - 1; i++) {
          if(i == j)
              continue;
          
             char c = line.charAt(i);
               char cn = line.charAt(i + 1);
             
             if((c == ',')){
                 complexity+=1;
             }
             else if((c == '.')){
                 complexity+=1;
             }else if((c == '-' && cn == '>')){
                 complexity+=1;
                 j = i + 1;
             }else if(c == ':' && cn == ':'){
                 complexity+=1;
                 j = i + 1;
             }
        
        }    
     
        return complexity;
    }
      
       public int keywords(String line){
          int complexity = 0;
          String[] words = {"void","double","int","float","String","printf","println","cout","cin","if","for","while",
                            "do-while","switch","case","long"};
          
          for (String word : words) {
            if (line.contains(word)) {
              complexity+=line.split(word).length - 1;
            }
          }
          
          return complexity;
      }
       
      public int manipulators(String line){
           int complexity = 0;
         if(line.contains("\\n"))
             complexity+=1;
             
         return complexity;
      }
      
      
       public int ndttskeywords(String line){
          int complexity = 0;
          String[] words = {"new","delete","throw","throws"};
          
          for (String word : words) {
            if (line.contains(word)) {
              complexity+=2;
            }
          }
          
          return complexity;
      }
      
      public int assignment(String line){
           int complexity = 0;
        String character = "abc";
        line+=character;
        int k = line.length() + 1;
        int j = line.length() + 1;
        int l = line.length() + 1;
        for (int i = 0; i < line.length() - 3; i++) {
          if(i == j || i == k || i == l)
              continue;
          
             char c = line.charAt(i);
               char cn = line.charAt(i + 1);
               char cnn = line.charAt(i + 2);
               char cnnn = line.charAt(i + 3);
               
             if(c == '>' && cn == '>' && cnn == '>' && cnnn == '='){
                 complexity+=1;
                 j = i + 1;
                 k = i + 2;
                 l = i + 3;
             }
             else if(c == '<' && cn == '<' && cnn == '='){
                 complexity+=1;
                 j = i + 1;
                 k = i + 2;
             }else if(c == '>' && cn == '>' && cnn == '='){
                 complexity+=1;
                 j = i + 1;
                 k = i + 2;
             }    
             else if((c == '|' || c == '&' || c == '%' || c == '^') &&  (cn == '=')){
                 complexity+=1;
                j = i + 1; 
             }else if((c == '+' || c == '-' || c == '*' || c == '/') && ( cn == '=')){
                 complexity+=1;
                 j = i + 1;
             }else if((c == '=' && cn != '=')){
                 if(i == 0)
                 complexity+=1;
                 else{
                     char x = line.charAt(i - 1);
                     if(x != '=' && x != '!' && x != '<' && x != '>')
                         complexity+=1;
                 }
                  
             }
        
        }    
     
        return complexity;
      }
      
      public int numeric(String line){
         
      char[] chars = line.toCharArray();
      StringBuilder sb = new StringBuilder();
      for(char c : chars){
         if(Character.isDigit(c)){
            sb.append(c);
         }
      }
        return sb.length();
      }
      
      public int doubleqoutes(String line){
          int complexity = 0;
          int result = 0;
          int z = 0;
          int index = 0;
          for (int i = 0; i < line.length(); i++) {
              
              char c = line.charAt(i);
               if(c == '"'){
                   if(index == 0){
                    index = i;
                   }else{
                       if(i > index + 1 ){
                           for(z = index + 1; z <= i ; z++){
                               char c2 = line.charAt(z);
                               if(c2 != ' ')
                                   result = 1;
                           }
                           
                       }   
                       if(result > 0){
                           complexity+=1;
                           index = 0;
                           result = 0;
                       }
                   }
                       
               }
               
          }
          
          
          return complexity;
      }
      
     public int[] classMethodObject(String line){
          int[] complexity;
          complexity = new int[4];
          
     
          
          complexity[0]+= findClass(line);
          complexity[1]+= findMethod2();
          complexity[2]+= variables(line);
          complexity[3]+= findarray(line);
          
          return complexity;
      }
     
     public int findClass(String line){
          int complexity = 0;
         
          if(line.contains("class") && line.contains("{")){
                        complexity +=1;
                  }
          
           
          return complexity;
      }
      
      
      public int findMethod2(){
          int complexity = 0;
          String[] mName = {"null","null","null"};
          int j = 0;
          int method = 0;
          BufferedReader reader;
          try{
               String path = FXMLDocumentController.filepath.replace("\\", "/");
            File file = new File(path);
           reader = new BufferedReader(new FileReader(
                             file));
           String line = reader.readLine();
                    while (line != null){
                         String[] words = {"void","double","int","float","long"};
                         
                         if(mName != null){
                             for(String name : mName){
                                 if(line.contains(name)){
                                     System.out.println(line);
                                     complexity+=line.split(name).length - 1;
                                 }
                             }
                             
                         }
      
      
                         if(line.contains("(") && line.contains(")") && (line.contains("public") || line.contains("private")) ){
                            for(String word : words){
                                if(line.contains(word)){
                                     method = 1;
                                     complexity+=1;
                                     String[] arrOfStr = line.split(" ");
                                     for(int i=0;i<arrOfStr.length;i++){
                                          if(arrOfStr[i].contains("(")){
                                              String[] split = arrOfStr[i].split("\\(");
                                              mName[j] = split[0];
                                              j++;
                                              System.out.println(mName);
                                          }
                                     }
                                }
                            }
                         }
                         
                         line = reader.readLine();
                    }
                    
                    reader.close();
           }catch(IOException e){
                    e.printStackTrace();
                }
          
          
          return complexity;
      }
      
       public int variables(String line){
          int complexity = 0;
          
           String[] words = {"int","float","double","boolean","String","long"};
          
          for (String word : words) {
            if (line.contains(word)) {
              if(line.contains("{")){
                  //nothing
              }else{
                  complexity+=1;
              }
            }
          }
         
         
           
          return complexity;
      }
       
         public int findarray(String line){
          int complexity = 0;
         
          if(line.contains("[") && line.contains("]")){
                        complexity +=1;
                  }
          
           
          return complexity;
      }
    
}
