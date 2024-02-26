import {createPortal} from "react-dom"
import classes from "./Modal.module.css"

export const Modal = (props) => {
    return createPortal(
        <div className={classes.modal + ' fixed-top'}>
            <div className={classes.modalContent}>
                {props.children}
                <button onClick={props.closeModal} className={'btn btn-outline-danger'}>Fermer</button>
            </div>
        </div>,
        document.body
    );
}

export default Modal;