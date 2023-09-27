package com.nhnacademy.aiot;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class SimpleCurl {
    String method = "GET";
    String url = "";
    int port = 80;
    String scheme = "";
    String host = "localhost";
    String version = "HTTP/1.1";
    String path = "";
    boolean verbose = false;
    String header = "";
    String data = "";
    boolean isLocation = false;

    public void getURL(String url) {
        scheme = url.split("://")[0]; // http://httpbin.org:80/get
        String splitURL = url.split("://")[1]; // httpbin.org:80/get
        int index = splitURL.indexOf('/', 0);
        path = splitURL.substring(index);
        host = splitURL.substring(0, index);
        if (host.contains(":")) {
            port = Integer.parseInt(host.split(":")[1]);
            host = host.split(":")[0];
        }
    }

    public static void main(String[] args) {
        SimpleCurl scurl = new SimpleCurl();
        Options options = new Options();

        options.addOption(Option.builder("v")
                .desc("verbose, 요청, 응답 헤더를 출력한다.").build());
        options.addOption(Option.builder("H").hasArg().argName("line")
                .desc("임의의 헤더를 서버로 전송한다.").build());
        options.addOption(Option.builder("d").hasArg().argName("data")
                .desc("POST, PUT 등에 데이터").build());
        options.addOption(Option.builder("x").hasArg().argName("command")
                .desc("사용할 method를 지정한다. 지정되지 않은 경우, 기본값은 GET").build());
        options.addOption(Option.builder("L")
                .desc("서버의 응답이 30x 계열이면 다음 응답을 따라 간다.").build());
        options.addOption(Option.builder("F").hasArg().argName("name=content")
                .desc("multipart/form-data를 구성하여 전송한다. content 부분에 @filename을 사용할 수 있다.").build());
        options.addOption(Option.builder("help")
                .desc("사용법을 출력합니다.").build());

        try {
            CommandLineParser parser = new DefaultParser();
            CommandLine cmd = parser.parse(options, args);
            Request request = new Request(scurl.host, scurl.port);

            if (cmd.hasOption("v")) {
                scurl.verbose = true;
                request.setVerbose(scurl.verbose);
            }
            if (cmd.hasOption("H")) {
                scurl.header = cmd.getOptionValue("H");
                request.setHeader(scurl.header);
            }
            if (cmd.hasOption("d")) {
                scurl.data = cmd.getOptionValue("d");
                request.setData(scurl.data);
            }
            if (cmd.hasOption("x")) {
                scurl.method = cmd.getOptionValue("x");
                if (!((scurl.method.equalsIgnoreCase("GET")) || (scurl.method.equalsIgnoreCase("PUT"))
                        || (scurl.method.equalsIgnoreCase("POST")))) {
                    throw new InvalidMethodException();
                }
            }
            if (cmd.hasOption("L")) {
                scurl.isLocation = true;
                request.setIsLocation(scurl.isLocation);
            }
            if (cmd.hasOption("F")) {
                System.out.println(cmd.getOptionValue("F"));
            }
            if (cmd.hasOption("help")) {
                HelpFormatter formatter = new HelpFormatter();
                formatter.setOptionComparator(null);
                formatter.printHelp("scurl", options);
            }
            scurl.getURL(cmd.getArgs()[0]);
            request.setHost(scurl.host);
            request.setPort(scurl.port);
            request.setMethod(scurl.method);
            request.setPath(scurl.path);
            request.setVersion(scurl.version);

            request.run();
        } catch (ParseException e) {
            HelpFormatter formatter = new HelpFormatter();
            formatter.setOptionComparator(null);
            formatter.printHelp("scurl", options);
        } catch (InvalidMethodException e) {
            System.err.println(e.getMessage());
        }
    }
}
