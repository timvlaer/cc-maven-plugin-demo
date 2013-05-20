package com.axxes.tim.maven_plugin_demo;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FileUtils;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;


@Mojo(name = "calculate-checksum")
public class CheckSumMojo extends AbstractMojo {

    public static final Charset UTF8 = Charset.forName("UTF-8");

    @Parameter(defaultValue = "${project}")
    private MavenProject mavenProject;

    @Parameter
    private File checksumFile;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        File artifactFile = mavenProject.getArtifact().getFile();
        getLog().info("Calculating checksum for artifact " + artifactFile.getAbsolutePath());
        try {
            FileInputStream fis = new FileInputStream(artifactFile);
            String md5Checksum = DigestUtils.md5Hex(fis);
            FileUtils.writeStringToFile(checksumFile, md5Checksum, UTF8);
        } catch (IOException e) {
            throw new MojoExecutionException("Could not calculate checksum.", e);
        }
    }
}
