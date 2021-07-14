export default { 
    filteredTodoItems(state) {
        if(!state.filter) {
            return state.todoItems
        }
    },
    getMonsterElements(state) {
        return state.monsterElements
    }
}