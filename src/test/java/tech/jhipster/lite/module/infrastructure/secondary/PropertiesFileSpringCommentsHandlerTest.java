package tech.jhipster.lite.module.infrastructure.secondary;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static tech.jhipster.lite.TestFileUtils.content;
import static tech.jhipster.lite.module.domain.JHipsterModule.comment;
import static tech.jhipster.lite.module.domain.JHipsterModule.propertyKey;

import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.Test;
import tech.jhipster.lite.TestFileUtils;
import tech.jhipster.lite.UnitTest;

@UnitTest
class PropertiesFileSpringCommentsHandlerTest {

  @Test
  void shouldNotCommentWhenFileNotExists() {
    String path = TestFileUtils.tmpDirForTest();
    Path propertiesFile = Paths.get(path, "src/main/resources/config/application.properties");

    new PropertiesFileSpringCommentsHandler(propertiesFile).set(propertyKey("spring.application.name"), comment("This is a comment"));

    Throwable thrown = catchThrowable(() -> {
      content(Paths.get(path, "src/main/resources/config/application.properties"));
    });
    assertThat(thrown).hasCauseInstanceOf(NoSuchFileException.class);
  }
}
