package edu.mum.cs.cs525.labs.exercises.project.ui.framework.account;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class FileMemoryAccountDao implements AccountDao {

    private static final String OUTPUT_DIR = System.getProperty("user.dir")
            + "/data_store";
    private String filename;
    private static Map<String, FileMemoryAccountDao> instances = new HashMap<>();

    private FileMemoryAccountDao(){}
    private FileMemoryAccountDao(String filename){
        this.filename = filename;
    }

    public static FileMemoryAccountDao getInstance(String filename){
        if(!instances.containsKey(filename))
            instances.put(filename, new FileMemoryAccountDao(filename));
        return instances.get(filename);
    }

    @Override
    public void saveAccount(Account account) {
        Map<String, Account> accounts = Optional.ofNullable(readFromStorage()).orElse(new HashMap<>());
        accounts.put(account.getAccountNumber(), account);
        saveToStorage(accounts);
    }

    @Override
    public Account getAccountByAccountNumber(String accountNumber) {
        return readFromStorage().get(accountNumber);
    }

    @Override
    public List<Account> getAllAccounts() {
        return readFromStorage().values().stream().toList();
    }

    private Map<String, Account> readFromStorage() {
        ObjectInputStream in = null;
        Object retVal = null;
        try {
            Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, filename);
            if (!Files.exists(path)) {
                File file = new File(path.toString());
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            in = new ObjectInputStream(Files.newInputStream(path));
            retVal = in.readObject();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if(in != null) {
                try {
                    in.close();
                } catch(Exception e) {}
            }
        }
        return (Map<String, Account>) retVal;
    }

    private void saveToStorage(Map<String, Account> ob) {
        ObjectOutputStream out = null;
        try {
            Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, filename);
            if (!Files.exists(path)) {
                File file = new File(path.toString());
                file.getParentFile().mkdirs();
                file.createNewFile();
            }

            out = new ObjectOutputStream(Files.newOutputStream(path));
            out.writeObject(ob);
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            if(out != null) {
                try {
                    out.close();
                } catch(Exception e) {}
            }
        }
    }
}
