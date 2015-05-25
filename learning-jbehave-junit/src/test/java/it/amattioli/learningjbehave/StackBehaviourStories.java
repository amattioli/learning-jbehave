package it.amattioli.learningjbehave;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromRelativeFile;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

public class StackBehaviourStories extends JUnitStories {
	
	public StackBehaviourStories() {
      configuredEmbedder().embedderControls().doIgnoreFailureInStories(false);
	}
		
	@Override
	public InjectableStepsFactory stepsFactory() {
		return new InstanceStepsFactory(configuration(), new StackBehaviourSteps());
	}
		
    @Override
    public Configuration configuration() {

        URL storyURL = null;
        try {
            // This requires you to start Maven from the project directory
            storyURL = new URL("file://" + System.getProperty("user.dir")
                    + "/src/main/resources/stories/");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        return new MostUsefulConfiguration()
                .useStoryLoader(new LoadFromRelativeFile(storyURL))
                .useStoryReporterBuilder(
                        new StoryReporterBuilder()
                                .withDefaultFormats()
                )
                ;
    }

	@Override
	protected List<String> storyPaths() {
		String codeLocation = CodeLocations.codeLocationFromClass(this.getClass()).getFile();
        return new StoryFinder().findPaths(codeLocation, 
        		                           Arrays.asList("**/*.story"), 
        		                           Arrays.asList(""), 
        		                           "file:" + codeLocation);
	}

}
