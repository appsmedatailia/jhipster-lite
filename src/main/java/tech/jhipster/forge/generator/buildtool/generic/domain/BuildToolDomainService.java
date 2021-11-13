package tech.jhipster.forge.generator.buildtool.generic.domain;

import static tech.jhipster.forge.generator.buildtool.generic.domain.BuildToolType.MAVEN;

import java.util.List;
import tech.jhipster.forge.error.domain.GeneratorException;
import tech.jhipster.forge.generator.buildtool.maven.domain.MavenService;
import tech.jhipster.forge.generator.project.domain.Project;

public class BuildToolDomainService implements BuildToolService {

  private final MavenService mavenService;

  public BuildToolDomainService(MavenService mavenService) {
    this.mavenService = mavenService;
  }

  @Override
  public void addParent(Project project, Parent parent) {
    if (project.isMavenProject()) {
      mavenService.addParent(project, parent);
    } else {
      throw new GeneratorException("No build tool");
    }
  }

  @Override
  public void addDependency(Project project, Dependency dependency) {
    if (project.isMavenProject()) {
      mavenService.addDependency(project, dependency);
    } else {
      throw new GeneratorException("No build tool");
    }
  }

  @Override
  public void addDependency(Project project, Dependency dependency, List<Dependency> exclusions) {
    if (project.isMavenProject()) {
      mavenService.addDependency(project, dependency, exclusions);
    } else {
      throw new GeneratorException("No build tool");
    }
  }

  @Override
  public void addPlugin(Project project, Plugin plugin) {
    if (project.isMavenProject()) {
      mavenService.addPlugin(project, plugin);
    } else {
      throw new GeneratorException("No build tool");
    }
  }

  @Override
  public void addProperty(Project project, String key, String version) {
    if (project.isMavenProject()) {
      mavenService.addProperty(project, key, version);
    } else {
      throw new GeneratorException("No build tool");
    }
  }

  @Override
  public void init(Project project, BuildToolType buildTool) {
    if (project.isMavenProject()) {
      throw new GeneratorException("Already existing build tool");
    }
    if (buildTool == MAVEN) {
      mavenService.init(project);
    }
  }
}
