//package com.app.playerservicejava.config;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.jdbc.datasource.init.ScriptUtils;
//import org.springframework.stereotype.Component;
//
//import javax.sql.DataSource;
//import java.io.File;
//import java.sql.Connection;
//import java.sql.SQLException;
//
///*
//- Use schema.sql to initialize the database only once.
//- Ensure subsequent application starts do not re-run schema.sql.
//
//Steps
//- Set initialization-mode to embedded to ensure schema.sql runs only for embedded databases.
//- Use a flag or a condition to check if the database is already initialized.
// */
//
//
//@Component
//public class DatabaseInitializer implements CommandLineRunner {
//
//    private final DataSource dataSource;
//
//    public DatabaseInitializer(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        File flagFile = new File("data/db_initialized.flag");
//        if (!flagFile.exists()) {
//            initializeDatabase();
//            flagFile.createNewFile();
//        }
//    }
//
//    private void initializeDatabase() throws SQLException {
//        try (Connection connection = dataSource.getConnection()) {
//            ScriptUtils.executeSqlScript(connection, new ClassPathResource("schema.sql"));
//        }
//    }
//}