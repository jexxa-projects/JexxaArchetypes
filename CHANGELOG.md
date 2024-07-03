# Change Log
All notable changes to this project will be documented in this file.
 
The format is based on [Keep a Changelog](http://keepachangelog.com/)
and this project adheres to [Semantic Versioning](http://semver.org/).

## \[3.0.3] - 2024-07-03
- Updated dependencies

## \[3.0.2] - 2024-05-29
### Fixed
- [jexxa-blank-archetype] Fixed template web page 
- Fixed default path for docker image in ghcr so that artifactid is used as directory name 
- Updated dependencies

## \[3.0.1] - 2024-03-24
### Fixed
- Location of git-cliff file is now located in the workflow directory
- Updated dependencies

## \[3.0.0] - 2024-03-03
### Added 
- Automatically update CHANGELOG if conventional commit messages are used 
- Automatically update CHANGELOG for dependabot updates

### Fixed
- Default properties in JLegMed archetype use artifactID as default postgres schema
- Excluded signature files from dependencies when building the fat jar. Otherwise, this will cause a security exception when starting the fat jar. 
- Updated dependencies 

### Removed
- `jexxa-archetype` since it is identical to jexxa tutorial [`bookstore`](https://github.com/jexxa-projects/JexxaTutorials/blob/main/BookStore/README.md)  

## \[2.0.2] - 2024-01-11
### Fixed
- Updated dependencies
- Fixed JLegMed archetype so that file `jlegmed-test.properties` is used during integration tests 

## \[2.0.1] - 2024-01-04
### Fixed
- Updated dependencies

## \[2.0.0] - 2023-12-16

### Changed
- Updated to new major versions of jexxa and jlegmed

## \[1.3.3] - 2023-12-05

### Fixed
- Updated dependencies

## \[1.3.2] - 2023-11-30

### Fixed
- Updated dependencies

## \[1.3.1] - 2023-11-19

### Fixed
- Default application properties for JLegMed blank archetype
- Updated dependencies

## \[1.3.0] - 2023-11-12
### Added
- Archetype for JLegMed projects

### Fixed
- Updated dependencies

## \[1.2.0] - 2023-10-14
### Added
- Possibility to define the used Java version

### Changed
- Default value for java version is now 21

## \[1.1.2] - 2023-10-01
### Fixed
- Updated dependencies
- Changed docker base-image from eclipse-temurin: 17-alpine into 17-jre-alpine 

## \[1.1.1] - 2023-09-17
### Fixed
- Updated dependencies

## \[1.1.0] - 2023-08-19

### Added
-   Archetype `jexxa-blank-archetype` to provide a project providing essential source code only.   
   
## \[1.0.0] - 2023-08-16
 
### Added
-   Initial Release providing archetype `jexxa-archetype`  
