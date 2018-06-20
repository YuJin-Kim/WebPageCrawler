package edu.handong.csee.java.webpagecrawler;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class Cli {
	String path;
	String url;
	boolean help;

	
	public void run(String[] args) {
		Options options = createOptions();

		if(parseOptions(options, args)){
			if (help){
				printHelp(options);
				return;
			}

		}
	}

	private boolean parseOptions(Options options, String[] args) {
		CommandLineParser parser = new DefaultParser();

		try {

			CommandLine cmd = parser.parse(options, args);

			path = cmd.getOptionValue("d");
			url = cmd.getOptionValue("u");
			help = cmd.hasOption("h");

		} catch (Exception e) {
			printHelp(options);
			return false;
		}

		return true;
	}

	// Definition Stage
	private Options createOptions() {
		Options options = new Options();

		// add options by using OptionBuilder
		options.addOption(Option.builder("d").longOpt("path")
				.desc("Set a path of a directory where the output file is saved")
				.hasArg()
				.argName("Path of directory")
				.required()
				.build());

		// add options by using OptionBuilder
		options.addOption(Option.builder("u").longOpt("url")
				.desc("Write a url where the web pages(html files) are saved ")
				.hasArg()
				.argName("Web page url")
				.required()
				.build());

		// add options by using OptionBuilder
		options.addOption(Option.builder("h").longOpt("help")
				.desc("Help")
				.build());

		return options;
	}

	private void printHelp(Options options) {
		// automatically generate the help statement
		HelpFormatter formatter = new HelpFormatter();
		String header = "WebPageCrawler";
		String footer ="\nPlease report issues at https://github.com/YuJin-Kim/WebPageCrawler.git";
		formatter.printHelp("WebPageCrawler", header, options, footer, true);
	}
}
