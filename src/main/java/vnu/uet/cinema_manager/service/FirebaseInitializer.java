package vnu.uet.cinema_manager.service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

//@Service
public class FirebaseInitializer {

//    @PostConstruct
    private void initDB() throws IOException {

//        InputStream serviceAccount =
//                this.getClass().getClassLoader().getResourceAsStream("/vnu/uet/cinema_manager/utils/config.json");
//
//        FirebaseOptions options = new FirebaseOptions.Builder()
//                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
//                .setDatabaseUrl("https://cinema-manager-9217a.firebase.com")
//                .build();
//
//        if(FirebaseApp.getApps().isEmpty()){
//            FirebaseApp.initializeApp(options);
//        }


        File file= new File("G:\\code_\\uet\\cinema_manager\\src\\main\\java\\vnu\\uet\\cinema_manager\\utils\\config.json");
        FileInputStream serviceAccount =
                new FileInputStream(file);
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();
        if(FirebaseApp.getApps().isEmpty()){
            FirebaseApp.initializeApp(options);
        }
    }

    public Firestore getFirebase(){
        return FirestoreClient.getFirestore();
    }
}
