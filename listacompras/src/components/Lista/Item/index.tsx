import { ITarefa } from '../../../types/tarefa'
import Button from '../../Button'
import style from './Item.module.scss'

interface Props extends ITarefa{
    selecionaTarefa: (tarefaSelecionada: ITarefa) => void
}

export default function Item({ tarefa, selecionado, completado, id, selecionaTarefa }: Props) {


    return (
        <li className={`${style.item} ${selecionado ? style.itemSelecionado : ''} ${completado? style.itemCompletado : ''}`} onClick={() => !completado &&  selecionaTarefa(
            {
            tarefa,
            selecionado,
            completado,
            id
        }
        )}>
            <h3>{tarefa}</h3>
            {completado && <span className={style.concluido} aria-label="Tarefa Completada"></span>}
        <Button>Remover</Button>
        
        </li>
    )

}