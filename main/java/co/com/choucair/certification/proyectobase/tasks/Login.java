package co.com.choucair.certification.proyectobase.tasks;

import co.com.choucair.certification.proyectobase.model.LoginTabla;
import co.com.choucair.certification.proyectobase.userinterface.ChoucairLoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.util.List;


public class Login implements Task {
    private List<LoginTabla> loginTabla;

    public Login(List<LoginTabla> loginTabla) {
        this.loginTabla = loginTabla;
    }

    public static Login onThePage(List<LoginTabla> logintabla) {
        return Tasks.instrumented(Login.class,logintabla);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(ChoucairLoginPage.LOGIN_BUTTON),
                Enter.theValue(loginTabla.get(0).getUsuario()).into(ChoucairLoginPage.INPUT_USER),
                Enter.theValue(loginTabla.get(0).getContrasena()).into(ChoucairLoginPage.INPUT_PASSWORD),
                Click.on(ChoucairLoginPage.ENTER_BUTTON)
        );
    }
}
