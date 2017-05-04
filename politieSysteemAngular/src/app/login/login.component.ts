import { Component } from '@angular/core'
import { LoginService } from 'app/global/login.Service'
import { UserService } from 'app/rest/user.Service';

@Component({
    selector : 'login-page',
    templateUrl : './login.html',
    styleUrls: ['./../app.component.css']
})
export class LoginComponent {

    loginErrorMessage : String;

    constructor(private loginService : LoginService, private userService : UserService){}

    login(username: String, password: String){
        this.userService.getUserByUsernameAndPassword(username, password)
                        .then(result => {
                            if(result != null){
                                this.loginService.loginUser = result
                                this.loginService.loginPage = true
                                this.loginService.loginStatus = true
                            }else{
                                this.loginErrorMessage = 'Incorrecte gebruikernaam of wachtwoord!!';
                            }
                        })
        
    }
}
