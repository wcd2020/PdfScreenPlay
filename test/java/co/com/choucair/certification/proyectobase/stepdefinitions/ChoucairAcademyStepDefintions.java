package co.com.choucair.certification.proyectobase.stepdefinitions;

import co.com.choucair.certification.proyectobase.model.LoginTabla;
import co.com.choucair.certification.proyectobase.questions.Answer;
import co.com.choucair.certification.proyectobase.tasks.Login;
import co.com.choucair.certification.proyectobase.tasks.OpenUp;
import co.com.choucair.certification.proyectobase.tasks.Search;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;

public class ChoucairAcademyStepDefintions {

    @Before
    public void setStage(){OnStage.setTheStage(new OnlineCast()); }

    @Given("^than brandon wants to learn automation at de academy choucair$")
    public void thanBrandonWantsToLearnAutomationAtDeAcademyChoucair(List<LoginTabla> logintabla) {
        OnStage.theActorCalled("brandon").wasAbleTo(OpenUp.thePage());

            OnStage.theActorCalled("brandon").wasAbleTo(Login.onThePage(logintabla));
    }
    @When("^he search for the course resources (.*) on the choucair academy platform$")
    public void heSearchForTheCourseResourcesAutomationBancolombiaOnTheChoucairAcademyPlatform(String course) {
    OnStage.theActorInTheSpotlight().attemptsTo(Search.the(course));
    }

    @Then("^he finds the course resources (.*)$")
    public void heFindsTheCourseResourcesAutomationBancolombia(String question) {
    OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(Answer.toThe(question)));
    }

}
