import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.jmolecules.archunit.JMoleculesArchitectureRules;
import org.jmolecules.archunit.JMoleculesDddRules;
import org.jmolecules.ddd.types.AggregateRoot;
import org.jmolecules.ddd.types.Entity;
import org.jmolecules.ddd.types.ValueObject;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "de.codecentric.recipedddexample")
class ArchitectureTests {

    @ArchTest
    ArchRule ensureDddRules = JMoleculesDddRules.all();

    @ArchTest
    ArchRule ensureOnionRules = JMoleculesArchitectureRules.ensureOnionClassical();

    @ArchTest
    ArchRule ensureHexagonalRules = JMoleculesArchitectureRules.ensureHexagonal();
}
