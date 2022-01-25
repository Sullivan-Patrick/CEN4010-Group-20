#Contributing

* Use [Google Style](https://medium.com/swlh/configuring-google-style-guide-for-java-for-intellij-c727af4ef248) for contributing.
  We won't use Checkstyle at first while you're all getting acclimated to all this new stuff, but eventually it should be an acceptance criteria
* Run `mvn clean verify` locally to run any tests that will happen on the CI pipeline. If you do this, you shouldn't have build issues on GitHub.
* Any new non-data class you add should have an associated {className}Test.java file associated with it, located in `src/test/java`. A data class
is a class that contains only fields (no functions outside of getters/setters).