import { View, Text, Modal, TextInput, Button, StyleSheet, Image } from 'react-native'
import React, { useEffect, useState } from 'react'
import IconCart from '../assets/img/iconeCart.png';
const FormArticle = (props) => {
    const [article, onChangeArticle] = useState('');
    useEffect(()=> {
        console.log(article);
    }, [article])
    const handleSubmit = () =>  {
        if(article.length > 3){
            props.addArticle(article);
            onChangeArticle('');
        }
    }
    return (
        <Modal visible={props.visible}>
            <View style={styles.view}>
                <View>
                    <Image style={styles.image} source={IconCart} />
                </View>
                <TextInput style={styles.input} value={article} onChangeText={onChangeArticle} />
                <View style={styles.viewButton}>
                    <View style={styles.button}>
                        <Button  title={'Ajouter article'} onPress={handleSubmit}/>
                    </View>
                    <View style={styles.button}>
                        <Button color={'red'} title={'Cancel'} onPress={props.closeModal} />
                    </View>
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
    viewButton: {
        margin: 30,
        flexDirection: 'row'
    },
    button: {
        margin: 15
    },
    input: {
        height: 50,
        width: 300,
        borderColor: 'black',
        borderWidth: 1,
        borderRadius: 25,
        padding: 15,
        backgroundColor: 'white'
    },
    image: {
        height: 200,
        width: 200
    }
})
export default FormArticle