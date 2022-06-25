import { Link } from 'react-router-dom';
import 'pages/Login/style.css';

function Login() {

    return (
        <>
            <div className="login-container">
                <div className="login-background-container"></div>
                <div className="fintech-container">
                    <div className="fintech-title">
                        <p className="title-paragraph">fintech</p>
                    </div>
                    <div className="fintech-description">
                        <p className="description-paragraph">
                            Conquiste e <span className="color-effect">viva</span> <br /> sua <span className="color-effect">independência</span>
                        </p>
                    </div>
                </div>
                <div className="fintech-login-container">
                    <div className="credentials-login">
                        <div className="credentials-title">
                            <p className="login-paragraph">SIGN IN</p>
                        </div>
                        <div className="credentials-info">
                            <input type="email" className="info-obj email-paragraph" placeholder="email" />
                            <input type="password" className="info-obj password-paragraph" placeholder="password" />
                        </div>
                    </div>
                    <div className="btn-login-container">
                        <a href="" className="btn-login">Login</a>
                            <a href="" className="create-acount">Não tem conta? <span className="create-acount-effect"><Link to='/cadastro' className='link'>Cadastre-se</Link></span></a>
                    </div>
                </div>
            </div>
        </>
    );
}

export default Login;