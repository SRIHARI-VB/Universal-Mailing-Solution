package ums.emailEvents;

import java.util.HashMap;
import java.util.Map;

import javafx.beans.property.SimpleStringProperty;

public class MaintainEmailMessages {

    public static Map<String,Integer> formatted=new HashMap<String,Integer>();
    private SimpleStringProperty sender;
    private SimpleStringProperty subject;
    private SimpleStringProperty size;

    public MaintainEmailMessages(String sender, String subject,
            int size) {
        this.sender = new SimpleStringProperty(sender);
        this.subject = new SimpleStringProperty(subject);
        this.size = new SimpleStringProperty(changeSizeFormat(size));
    }

    public String getSender(){
        return sender.get();
    }

    public String getSubject() {
        return subject.get();
    }

    public String getSize() {
        return size.get();
    }

    public String changeSizeFormat(int size){
        String result;
        if(size<=0){
            result="0";
        }
        else if(size<1024){
            result=size+" B";
        }
        else if(size<1048576){
            result=size/1024+" KB";
        }
        else{
            result=size/1048576+" MB";
        }
        formatted.put(result, size);
        return result;
    }


    
}
