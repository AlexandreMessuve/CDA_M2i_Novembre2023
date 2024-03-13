import { Button, Pressable, StyleSheet, Text, TextInput, View, Modal } from 'react-native'
import React, { useState } from 'react'

const FormContact = (props) => {
    const [firstname, setFirstname] = useState('');
    const [lastname, setLastname] = useState('');
    const [phone, setPhone] = useState('');
    const [address, setAddress] = useState('');

    const handleSubmit = () => {
        const condition = firstname.length > 0 && lastname.length > 0 && phone.length > 0 && address.length > 0
        if (condition) {
            const newContact = {
                id: Date.now(),
                firstname: firstname,
                lastname: lastname,
                phone: phone,
                address: address
            }
            props.addContact(newContact);
            setFirstname('');
            setLastname('');
            setPhone('');
            setAddress('');
        }else{
            alert('Tous les champs sont requis !')
        }
    }
    return (
        <Modal visible={props.visible}>
            <View style={styles.view}>
                <Text style={styles.title}>Ajouter un contact : </Text>
                <TextInput style={styles.input} value={firstname} onChangeText={setFirstname} placeholder={'Prénom'} />
                <TextInput style={styles.input} value={lastname} onChangeText={setLastname} placeholder={'Nom'} />
                <TextInput style={styles.input} value={phone} onChangeText={setPhone} placeholder={'Téléphone'} />
                <TextInput style={styles.input} value={address} onChangeText={setAddress} placeholder={'Adresse'} />
                <View style={styles.viewButton}>
                    <Pressable
                        style={({ pressed }) => [styles.button, styles.buttonSubmit, (pressed) && styles.buttonSubmitPress]}
                        onPress={handleSubmit}>
                        <Text style={styles.buttonText}>Ajouter</Text>
                    </Pressable>
                    <Pressable
                        style={({ pressed }) => [styles.button, styles.buttonCancel, (pressed) && styles.buttonCancelPress]}
                        onPress={props.closeModal}>
                        <Text style={styles.buttonText}>Cancel</Text>
                    </Pressable>
                </View>
            </View>
        </Modal>
    )
}

export default FormContact

const styles = StyleSheet.create({
    view: {
        flex: 1,
        alignItems: 'center',
        justifyContent: 'center'
    },
    input: {
        width: 400,
        height: 60,
        borderRadius: 40,
        backgroundColor: 'antiquewhite',
        margin: 10
    },
    title: {
        fontSize: 40,
        fontWeight: '700',
        margin: 25
    },
    viewButton: {
        flexDirection: 'row'
    },
    button: {
        height: 50,
        width: 100,
        borderRadius: 40,
        alignContent: 'center',
        justifyContent: 'center',
        marginVertical: 30,
        marginHorizontal: 30
    },
    buttonText: {
        color: 'white',
        textAlign: 'center'
    },
    buttonSubmit: {
        backgroundColor: '#3374FF'
    },
    buttonSubmitPress: {
        backgroundColor: '#33A2FF'
    },
    buttonCancel: {
        backgroundColor: '#FF3333'
    },
    buttonCancelPress: {
        backgroundColor: '#FF6E33'
    }
})