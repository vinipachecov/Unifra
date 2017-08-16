/*************************************************************************
 * Copyright (c) 2013 eProsima. All rights reserved.
 *
 * This copy of Fast Buffers is licensed to you under the terms described in the
 * FAST_BUFFERS_LICENSE file included in this distribution.
 *
 *************************************************************************/

#ifndef _FASTCDR_EXCEPTIONS_EXCEPTION_H_
#define _FASTCDR_EXCEPTIONS_EXCEPTION_H_

#include "fastcdr/FastCdr_dll.h"
#include <string>
#include <exception>

namespace eprosima
{
    /*!
    * @brief This abstract class is used to create exceptions.
    * @ingroup EXCEPTIONMODULE
    */
    class Cdr_DllAPI Exception : public std::exception
    {
    public:

        //! \brief Default destructor.
        virtual ~Exception() throw();

        //! \brief This function throws the object as exception.
        virtual void raise() const = 0;

        /*!
         * @brief This function returns the error message.
         *
         * @return The error message.
         */
        virtual const char* what() const throw() ;

    protected:

        /*!
         * @brief Default constructor.
         *
         * @param message A error message. This message is copied.
         */
        Exception(const std::string &message);

        /*!
         * @brief Default constructor.
         *
         * @param message A error message. This message is moved.
         */
        Exception(std::string&& message);

        /*!
         * @brief Default copy constructor.
         *
         * @param ex Exception that will be copied.
         */
        Exception(const Exception &ex);

        /*!
         * @brief Default move constructor.
         *
         * @param ex Exception that will be moved.
         */
        Exception(Exception&& ex);

        /*!
         * @brief Assigment operation.
         *
         * @param ex Exception that will be copied.
         */
        Exception& operator=(const Exception &ex);

        /*!
         * @brief Assigment operation.
         *
         * @param ex Exception that will be moved.
         */
        Exception& operator=(Exception&&);

    private:

        std::string m_message;
    };
} // namespace eprosima

#endif // _FASTCDR_EXCEPTIONS_EXCEPTION_H_
