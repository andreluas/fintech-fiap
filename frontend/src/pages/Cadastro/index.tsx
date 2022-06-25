import { HiOutlineArrowLeft } from "react-icons/hi";
import { HiDotsHorizontal } from "react-icons/hi";
import { Link } from 'react-router-dom';
import 'pages/Cadastro/style.css';

function Cadastro() {

    return (
        <>
            <div className="cadastro-container">
                <div className="header-cadastro">
                    <button className="arrow-btn">
                        <Link to='/' className='link'>
                            <HiOutlineArrowLeft />
                        </Link>
                    </button>
                    <p className="entrar-paragraph">Entrar</p>
                    <button className="dot-btn">
                        <HiDotsHorizontal />
                    </button>
                </div>
                <div className="email-container">
                    <h1 className="first-paragraph"><span className="cadastro-effect">Bem-vindo,</span> <br /> insira seu usuário</h1>
                    <input type="email" className="input-cadastro" />
                    <p className="obs-paragraph">Entrar com e-mail</p>
                </div>
                <div className="password-container">
                    <h1 className="second-paragraph">perfeito, agora <br /> insira a <span className="cadastro-effect">sua senha</span></h1>
                    <input type="password" className="input-cadastro" />
                </div>
                <div className="cadastro-btn-container">
                    <a href="/" className="cadastro-btn">Avançar</a>
                </div>
            </div>
        </>
    );
}

export default Cadastro;