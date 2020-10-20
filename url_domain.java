package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static String getDomainName(String url) throws URISyntaxException {
        URI uri = new URI(url);
        String domain = uri.getHost();
        return domain.startsWith("www.") ? domain.substring(4) : domain;
    }

    public static void main(String[] args) throws UnknownHostException {
        ArrayList<String> list = new ArrayList<>();

        System.out.println("Enter URL: ");
        Scanner console = new Scanner(System.in);
        String name_url = console.nextLine();
        String domain_name = "";

        Integer k = 0;
        Integer d = 0;

        try {
            File f = new File("register.txt");
            BufferedReader b = new BufferedReader(new FileReader(f));
            String readLine = "";

            while ((readLine = b.readLine()) != null) {
                if (readLine.contains(name_url)) {
                    k = 1;
                }
                domain_name = getDomainName(name_url);
                if (readLine.contains(domain_name))
                    d = 1;
            }

        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }

        System.out.println("Domain name is " + domain_name);

        if(k == 1){
            System.out.println("This URL is banned");
            if(d == 1)
                System.out.println("This domain is banned");
        }
        else if (k == 0) {
            System.out.println("This URL is not banned");
            if(d == 0)
                System.out.println("This domain is not banned");
        }
        try {
            InetAddress[] iaRemoteAll;
            iaRemoteAll = InetAddress.getAllByName(domain_name);
            for (int i = 0; i < iaRemoteAll.length; i++) {
                System.out.println(iaRemoteAll[i]);
            }
        } catch (UnknownHostException e) {
            //e.printStackTrace();
            System.out.println("IP is blocked in Russia");
        }

    }
}
