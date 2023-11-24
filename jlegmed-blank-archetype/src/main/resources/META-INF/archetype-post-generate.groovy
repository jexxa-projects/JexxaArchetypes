void renameDir() {
    println "Executing the archetype-post-generate.groovy script..."

    def rootDir = new File(request.getOutputDirectory() + "/" + request.getArtifactId())
    if (!rootDir.exists()) {
        println "Root directory does not exist" + rootDir;
        rootDir  = new File(request.getOutputDirectory() + "/" ).listFiles()[0];
        println "New Root directory is" + rootDir;
    }
    def projectDir = request.getOutputDirectory() + "/" + request.getProperties().getProperty("projectName")
    rootDir.renameTo(new File(projectDir))
}
renameDir()