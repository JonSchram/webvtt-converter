package com.jonathanschram.vttconverter.cli;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import com.jonathanschram.vttconverter.lib.vtt.VttParser;

public class ConverterCli {

	public static void main(String[] args) throws ParseException {
		CommandLine commandArgs = parseCommandLineArgs(args);
		
		if (!commandArgs.hasOption("help") && !commandArgs.hasOption("version")) {
			// Neither "help" or "version" is set, continue.
			
			List<String> unparsedArgs = commandArgs.getArgList();
			for (String path : unparsedArgs) {
				File input = new File(path);
				try {
					VttParser parser = new VttParser(new FileInputStream(input));
					parser.parseFromStream();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	private static CommandLine parseCommandLineArgs(String[] args) throws ParseException {
		/*
		 * According to this (https://stackoverflow.com/a/10798771) answer by Forage
		 * (https://stackoverflow.com/users/143224/forage) on StackOverflow, Apache
		 * Commons CLI doesn't allow setting some arguments required without also
		 * allowing a "help" option to be used without those required arguments.
		 * 
		 * With the number of arguments that will likely be required to configure the
		 * conversion, I think it would be easier to manually validate the arguments.
		 * 
		 */

		Options options = new Options();

		// Rendering.
		options.addOption(Option.builder("x").longOpt("xresolution").hasArg().type(Integer.class)
				.desc("The x-resolution of the screen that ASS subtitles will be rendered on. Required.").build());
		options.addOption(Option.builder("y").longOpt("yresolution").hasArg().type(Integer.class)
				.desc("The y-resolution of the screen that ASS subtitles will be rendered on. Required").build());
		options.addOption(Option.builder("m").longOpt("mediumfontsize").hasArg().type(Integer.class)
				.desc("Size of medium font in points. Other font sizes will be calculated from this value.").build());

		// Features unique to ASS, configure workaround.
		options.addOption(Option.builder().longOpt("verticalbehavior").hasArg().desc(
				"How to handle vertical styles in VTT file. \"rotate\" will rotate the entire subtitle (default). \"break\" will insert line breaks after each character.")
				.build());

		// Informational.
		options.addOption(Option.builder("v").longOpt("version").desc("Print version information").build());
		options.addOption(Option.builder("h").longOpt("help").desc("Print this message").build());

		CommandLineParser parser = new DefaultParser();
		CommandLine cmd = parser.parse(options, args);
		
		if (cmd.hasOption("help")) {
			// Help formatter must have access to options.
			HelpFormatter formatter = new HelpFormatter();
			formatter.printHelp("vttconverter", options, true);
		}
		
		return cmd;

	}

}
