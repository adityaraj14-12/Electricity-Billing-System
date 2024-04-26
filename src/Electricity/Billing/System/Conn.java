package Electricity.Billing.System;

import java.sql.*;

public class Conn {

    Connection c;
    Statement s;
    Conn() {
        try {
            c = DriverManager.getConnection("jdbc:mysql:///ebs", "root", "adityaraja121");
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
