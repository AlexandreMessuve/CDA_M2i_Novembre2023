import { StyleSheet, View, Button, FlatList, Text, TextInput } from 'react-native'
import React, {useEffect, useState } from 'react'
import Exercice01 from './components/Exercice01/Exercice01';
import Exercice02 from './components/Exercice02/Exercice02';
export default App = () => {
    const [modalEx01, setModalEx01] = useState(false);
    const [modalEx02, setModalEx02] = useState(false);

    const openModal = (type) => {
        switch (type) {
            case 'ex01':
                setModalEx01(true);
                break;
            case 'ex02':
                setModalEx02(true);
                break;
            default:
                break;
        } 
    }
    const closeModal = (type) => {
        switch (type) {
            case 'ex01':
                setModalEx01(false);
                break;
            case 'ex02':
                setModalEx02(false);
                break;
            default:
                break;
        } 
    }
    return (

        
            <View style={styles.view}>
                <View>
                    <Text style={styles.title}>Liste des exercices</Text>
                </View>
                <View>
                    <Button title={'Exercice01'} onPress={() => openModal('ex01')} />

                </View>
                <Exercice01 visible={modalEx01} closeModal={() => closeModal('ex01')} />
                <View>
                    <Button title={'Exercice02'} onPress={() => openModal('ex02')} />
                </View>
                <Exercice02 visible={modalEx02} closeModal={() => closeModal('ex02')} />
            </View>
    )
}

const styles = StyleSheet.create({

    title: {
        fontSize: 30,
        fontWeight: '800',
        marginBottom: 30

    },

    view: {
        backgroundColor: '#F5F5DC',
        flex: 1,
        justifyContent: 'center',
        alignItems: 'center'
    },
    listText: {
        fontSize: 25,
    },
    input: {
        height: 50,
        width: 300,
        borderColor: 'black',
        borderWidth: 1,
        borderRadius: 25,
        padding: 15,
        backgroundColor: 'white'
    }
});
