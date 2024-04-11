import { View, Text, Modal, TextInput, Button, StyleSheet } from 'react-native'
import React, { useEffect, useState } from 'react'

const FormArticle = (props) => {
    const [article, onChangeArticle] = useState('');
    useEffect(()=> {
        console.log(article);
    }, [article])
    const handleSubmit = () =>  {
        props.addArticle(article);
        onChangeArticle('');
    }
    return (
        <Modal visible={props.visible}>
            <View style={styles.view}>
                <TextInput value={article} onChangeText={onChangeArticle} />
                <View>
                    <Button title={'Ajouter article'} onPress={handleSubmit}/>
                    <Button title={'Cancel'} onPress={props.closeModal} />
                </View>
            </View>
        </Modal>
    )
}
const styles = StyleSheet.create({
    view: {
        flex: 1,
        justifyContent: 'center',
        alignItems: 'center'
    },
    input:{
        
    }
})
export default FormArticle