import React, { useState } from 'react';
import { v4 as uuidv4 } from 'uuid';
import { ITarefa } from '../../types/tarefa';
import Button from '../Button';
import style from './Formulario.module.scss';

interface Props{
    setTarefas: React.Dispatch<React.SetStateAction<ITarefa[]>>
}


function Formulario({ setTarefas } : Props) {

    const[tarefa, setTarefa] = useState("")
    const [tempo, setTempo] = useState("00:00")


    function adicionarTarefa(evento: React.FormEvent<HTMLFormElement>) {
        evento.preventDefault();
        setTarefas(tarefasAntigas => 
            [
            ...tarefasAntigas,
            {
                tarefa,
                tempo,
                selecionado: false,
                completado: false,
                id: uuidv4()
            }])
        setTarefa("");
        setTempo("00:00");
    }
    return (
        <form className={style.novaTarefa} onSubmit={ adicionarTarefa}>
                <div className={style.inputContainer}>
                    <label htmlFor="tarefa">
                        Adicione um novo item
                    </label>
                    <input
                        type="text"
                        name="tarefa"
                        value={tarefa}
                        onChange={evento => setTarefa(evento.target.value) }
                        id="tarefa"
                        placeholder="O que você quer estudar"
                        required
                    />
                </div>
                <Button type="submit">
                    Adicionar
                </Button>

            </form>
    )
}





export default Formulario;