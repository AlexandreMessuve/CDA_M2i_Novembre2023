import { Pressable, StyleSheet, Text, TextInput, View } from 'react-native'
import React, { useEffect, useState } from 'react'

const FormContact = ({navigation, route}) => {
    const addContact = route.params.addContact
    const [formData, setFormData] = useState({
        firstname: '',
        lastname: '',
        phone: '',
        address: ''
    });

    const handleChangeText = (index, value) => {
        setFormData({ ...formData, [index]: value })
    }
    const handleSubmit = () => {
        const condition = formData.firstname.length > 0 && formData.lastname.length > 0 && formData.phone.length > 0 && formData.address.length > 0
        if (condition) {
            addContact(formData);
            setFormData({
                firstname: '',
                lastname: '',
                phone: '',
                address: '',
            })
            navigation.navigate('Contacts')
        } else {
            alert('Tous les champs sont requis !')
        }
    }
    useEffect(() => {
        if (!formData.id) {
            setFormData({ ...formData, id: Date.now() });
        }
        console.log(formData);
    }, [formData])
    return (
            <View style={styles.view}>
                <Text style={styles.title}>Ajouter un contact : </Text>
                <View>
                    <TextInput style={styles.input} value={formData.firstname} onChangeText={(text) => handleChangeText('firstname', text)} placeholder={'Prénom'} />
                    <TextInput style={styles.input} value={formData.lastname} onChangeText={(text) => handleChangeText('lastname', text)} placeholder={'Nom'} />
                    <TextInput style={styles.input} value={formData.phone} onChangeText={(text) => handleChangeText('phone', text)} placeholder={'Téléphone'} />
                    <TextInput style={styles.input} value={formData.address} onChangeText={(text) => handleChangeText('address', text)} placeholder={'Adresse'} />
                </View>

                <View style={styles.viewButton}>
                    <Pressable
                        style={({ pressed }) => [styles.button, styles.buttonSubmit, (pressed) && styles.buttonSubmitPress]}
                        onPress={handleSubmit}>
                        <Text style={styles.buttonText}>Ajouter</Text>
                    </Pressable>
                </View>
            </View>
    )
}

export default FormContact

const styles = StyleSheet.create({
    view: {
        flex: 1,
        alignItems: 'center',
        justifyContent: 'space-around',
        backgroundColor: '#663180',
    },
    input: {
        width: 400,
        height: 60,
        borderWidth: 2,
        borderRadius: 40,
        borderColor: 'black',
        backgroundColor: '#E9E1EE',
        margin: 10,
        textAlign: 'center'
    },
    title: {
        fontSize: 40,
        fontWeight: '700',
        margin: 25,
        color: 'white'
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