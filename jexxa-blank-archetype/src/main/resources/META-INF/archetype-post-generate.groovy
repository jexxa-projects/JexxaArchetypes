void renameDir() {
    println "Executing the archetype-post-generate.groovy script..."

    def rootDir = new File(request.getOutputDirectory() + "/" + request.getArtifactId())
    def projectDir = request.getOutputDirectory() + "/" + request.getProperties().getProperty("projectName")
    rootDir.renameTo(new File(projectDir))
}
renameDir()