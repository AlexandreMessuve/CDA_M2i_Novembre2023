import * as YUP from 'yup';
import * as regex from '../constants/regex.js';

export default YUP.object().shape({
    email: YUP.string().email('email non valide exemple: exemple@exemple.com').matches(regex.EMAIL, 'email non valide exemple: exemple@exemple.com').required('L\'Email est requis'),
    username: YUP.string().matches(regex.USERNAME, 'L\'username doit avoir 4 caractère minimum et ne pas contenir de caractères spéciaux').required('L\'username est requis'),
    password: YUP.string().matches(regex.PASSWORD, 'Votre mot de passe doit contenir 8 caractères min dont une minuscule, une majuscule & un numérique').required('Le mot de passe est requis'),
    confirmPass: YUP.string().oneOf([YUP.ref('password'), null], 'Les mot de passe ne sont pas identique').required('Confirmation du mot de passe est requis')
})