package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

	public void packFiles(List<File> files, File target) {
		try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
			for (File source : files) {
				zip.putNextEntry(new ZipEntry(source.getPath()));
				try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
					zip.write(out.readAllBytes());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void packSingleFile(File source, File target) {
		try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
			zip.putNextEntry(new ZipEntry(source.getPath()));
			try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
				zip.write(out.readAllBytes());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static List<Path> findPaths(ArgZip argZip) throws IOException {
		SearchFiles searcher = new SearchFiles(p -> !p.toFile().getName().endsWith(argZip.exclude()));
		Files.walkFileTree(Path.of(argZip.directory()), searcher);
		return searcher.getSearchPaths();
	}
	
	public static void main(String[] args) throws IOException {
		ArgZip argZip = new ArgZip(args);
		argZip.valid();
		List<Path> paths = findPaths(argZip);
		Zip zip = new Zip();
		zip.packFiles(paths.stream().map(Path::toFile).collect(Collectors.toList()), new File(argZip.output()));
		
	}
}
